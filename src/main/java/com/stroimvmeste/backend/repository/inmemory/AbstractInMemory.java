package com.stroimvmeste.backend.repository.inmemory;

import com.stroimvmeste.backend.model.Initiative;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractInMemory {
    protected final Map<Long, Object> storage = new HashMap<>();
}
