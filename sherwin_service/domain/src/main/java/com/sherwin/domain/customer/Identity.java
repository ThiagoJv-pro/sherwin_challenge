package com.sherwin.domain.customer;

import java.util.Objects;
import java.util.Optional;

public class Identity {
    
    private final String identity;
    private final String type;

    private Identity(String identity, String type) {
        this.identity = identity;
        this.type = type;
    }

    public String getIdentity() {
        return identity;
    }

    public String getType() {
        return type;
    }

    public static boolean isValidCpf(String identity){
        return Objects.nonNull(identity) && identity.matches("\\d{11}");
    }

    public static boolean isValidCnpj(String identity){
        return Objects.nonNull(identity) && identity.matches("\\d{14}");
    }

    public static Optional<Identity> createIdentity(String identity) {
        if(isValidCnpj(identity)) {
            return Optional.ofNullable(new Identity(identity,"cnpj"));
        } else if(isValidCpf(identity)){
            return Optional.ofNullable(new Identity(identity, "cpf"));
        }
        
        return Optional.empty();
    }

}
