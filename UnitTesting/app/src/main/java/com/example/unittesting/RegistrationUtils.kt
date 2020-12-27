package com.example.unittesting

object RegistrationUtils {

    fun validUser(username: String, password: String, confirmPassword: String): Boolean {
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return false;
        } else if (password != confirmPassword) {
            return false;
        }
        return true;
    }
}