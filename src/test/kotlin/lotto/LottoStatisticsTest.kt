package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.doubles.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

class LottoStatisticsTest : FreeSpec({
    "구매금액과 당첨금액을 이용해 수익률을 계산할 수 있다" {
        val money = 3_000
        val lottoResult = mapOf(
            Winning.FOURTH_PLACE to 2,
            Winning.THIRD_PLACE to 1,
        )

        val statistics = LottoStatistics(money, lottoResult)
        statistics.totalAmount shouldBe 60_000
        statistics.getYield() shouldBeGreaterThan 1.0
    }
})