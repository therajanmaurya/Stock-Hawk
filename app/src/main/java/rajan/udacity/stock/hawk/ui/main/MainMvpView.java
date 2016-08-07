package rajan.udacity.stock.hawk.ui.main;

import java.util.List;

import rajan.udacity.stock.hawk.data.model.Ribot;
import rajan.udacity.stock.hawk.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showRibots(List<Ribot> ribots);

    void showRibotsEmpty();

    void showError();

}
