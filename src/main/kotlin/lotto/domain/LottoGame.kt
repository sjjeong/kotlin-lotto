package lotto.domain

object LottoGame {

    const val LOTTO_PRICE = 1000

    fun pick(numberOfGames: Int, lottoFactory: LottoFactory) =
        List(numberOfGames) { lottoFactory.create() }

    fun getResultOfGames(gameBoard: List<Lotto>, winnerLotto: Lotto, bonusNumber: Int) =
        gameBoard.map {
            LottoGameResult.getResultOfWinning(
                numberOfMatches(it, winnerLotto),
                bonusOfMatches(it, bonusNumber)
            )
        }

    private fun numberOfMatches(lotto: Lotto, winnerLotto: Lotto) =
        lotto.numbers.filter { winnerLotto.numbers.contains(it) }.size

    private fun bonusOfMatches(lotto: Lotto, bonus: Int) =
        lotto.numbers.filter { bonus == it }.size
}
