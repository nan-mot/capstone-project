package com.stroimvmeste.backend.repository.inmemory;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.SneakyThrows;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractInMemory<T> {
    private Map<Long, T> storage = new HashMap<>();

    private final File storageFile;

    private final Class<?> contentClass;

    private Long maxId;

    public AbstractInMemory(String filename, Class<?> contentClass) {
        storageFile = new File(filename);
        this.contentClass = contentClass;
    }

    @SneakyThrows
    @PostConstruct
    public void init() {
        if (storageFile.exists()) {
            String content = Files.readString(storageFile.toPath(), Charset.defaultCharset());
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType type = objectMapper.getTypeFactory().
                    constructMapType(Map.class, Long.class, contentClass);
            storage = objectMapper.readValue(content, type);
            initMaxId();
        }
    }

    private void initMaxId() {
        maxId = storage.keySet().stream().max(Long::compareTo).orElse(0L);
    }

    @SneakyThrows
    public T save(T value) {
        Long id = (Long) FieldUtils.readDeclaredField(value, "id", true);
        if (id == null) {
            storage.put(++maxId, value);
            FieldUtils.writeDeclaredField(value, "id", maxId, true);
        } else {
            storage.put(id, value);
        }
        return value;
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    public Optional<T> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Iterable<T> findAll() {
        return storage.values().stream().toList();
    }

    @SneakyThrows
    @PreDestroy
    public void persist() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(storageFile, storage);
    }
}
