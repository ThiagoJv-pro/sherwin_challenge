package com.sherwin.domain;

public abstract class Entity<ID extends Identifier>{
    
    public final ID id;

    public Entity(final ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

}
