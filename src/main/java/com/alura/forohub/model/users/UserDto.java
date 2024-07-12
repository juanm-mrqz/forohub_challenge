package com.alura.forohub.model.users;

public record UserDto (
        String username,
        String userEmail
)
{
    public UserDto(User user) {
        this(user.getLogin(), user.getEmail());
    }
}
