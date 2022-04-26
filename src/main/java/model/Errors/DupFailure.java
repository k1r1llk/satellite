package model.Errors;


import model.Motion;

public class DupFailure implements SensorError {

    private Motion am;

    public DupFailure(Motion am, double p_err_t) {
        this.am = am;
        this.p_err_t = p_err_t;
    }

    private double p_err_t;

    @Override
    public double getX(double t) {
        if (t >= p_err_t) return 0;
        return am.getX();
    }

    @Override
    public double getDx(double t) {
        return am.getDx();
    }
}
