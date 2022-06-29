package lotto.entity

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTicketTest {
    @Test
    fun `로또 번호 입력으로 6개 미만의 숫자열이 들어가면 예외가 발생한다`() {
        // given
        val testNumbers = listOf<Int>(1, 2, 3)

        // then
        assertThrows<IllegalArgumentException> {
            LottoTicket(testNumbers)
        }
    }

    @Test
    fun `로또 번호 입력으로 6개 이상의 숫자열이 들어가면 예외가 발생한다`() {
        // given
        val testNumbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8)

        // then
        assertThrows<IllegalArgumentException> {
            LottoTicket(testNumbers)
        }
    }
}