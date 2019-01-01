package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate

import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }
}