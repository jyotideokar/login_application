package com.example.unittesting

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class RegistrationUtilsTest {

    @Test
    fun `empty username return false`() {
        val result = RegistrationUtils.validUser(
            "",
            "123",
            "123"
        )
        assert(!result)
    }

    @Test
    fun `empty password return false`() {
        val result = RegistrationUtils.validUser(
            "TestUser",
            "",
            "TestPassword"
        )
        assert(!result)
    }

    @Test
    fun `empty confirm password return false`() {
        val result = RegistrationUtils.validUser(
            "TestUser",
            "TestPassword",
            ""
        )
        assert(!result)
    }

    @Test
    fun `password and  confirm password does not match return false`() {
        val result = RegistrationUtils.validUser(
            "TestUser",
            "TestPassword",
            "PasswordTest"
        )
        assert(!result)
    }

    @Test
    fun `valid username and password return true`() {
        val result = RegistrationUtils.validUser(
            "TestUser",
            "TestPassword",
            "TestPassword"
        )
        assert(result)
    }

}