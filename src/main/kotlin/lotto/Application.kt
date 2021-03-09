package lotto

import lotto.domain.Count
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.RandomLottoGenerator
import lotto.view.inputMoney
import lotto.view.inputWinningLottoNumbers
import lotto.view.printLottos
import lotto.view.printResult
import lotto.view.printYield

fun main() {
    val purchase = Money(inputMoney())
    val count = Count(purchase / Lotto.PRICE)

    val lottos = Lottos(count.map { RandomLottoGenerator.generate() })

    printLottos(lottos)

    val winningNumbers = inputWinningLottoNumbers()
        .map { LottoNumber.of(it) }
        .toSet()
    val winningLotto = Lotto(winningNumbers)

    val result = lottos.match(winningLotto)
    printResult(result)

    val yield = result.calculateYield(purchase)
    printYield(`yield`)
}