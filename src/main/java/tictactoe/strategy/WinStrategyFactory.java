package tictactoe.strategy;

public class WinStrategyFactory {

    public IWinStrategy newStandardWinStrategy() {
        return new BaseWinStrategy();
    }
    public IWinStrategy newVerticalWinStrategy() {
        return new VerticalWinStrategy();
    }
    public IWinStrategy newHorizontalWinStrategy() {
        return new HorizontalWinStrategy();
    }
    public IWinStrategy newDiagonalWinStrategy() {
        return new DiagonalWinStrategy();
    }

}
