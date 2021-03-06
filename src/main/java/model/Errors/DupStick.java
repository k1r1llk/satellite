package model.Errors;

import model.Motion;

public class DupStick implements SensorError {
    private Motion am;
    private double dupStickValue = 0;

    private double p_err_t;

    public DupStick(Motion am, double p_err_t) {
        this.am = am;
        this.p_err_t = p_err_t;
    }

    @Override
    public double getX(double t) {
        if (t == p_err_t) dupStickValue = am.getX();
        if (t >= p_err_t) return dupStickValue;
        return am.getX();
    }

    @Override
    public double getDx(double t) {
        return am.getDx();
    }
}
