package dev.skidfuscator.obf.number.encrypt.impl;

import dev.skidfuscator.obf.maple.FakeArithmeticExpr;
import dev.skidfuscator.obf.number.encrypt.NumberTransformer;
import org.mapleir.ir.code.Expr;
import org.mapleir.ir.code.expr.ArithmeticExpr;
import org.mapleir.ir.code.expr.ConstantExpr;

/**
 * @author Ghast
 * @since 09/03/2021
 * SkidfuscatorV2 © 2021
 */
public class XorNumberTransformer implements NumberTransformer {
    @Override
    public Expr getNumber(final Number outcome, final Number starting, final Expr startingExpr) {
        final int xored = outcome.intValue() ^ starting.intValue();
        final Expr allocExpr = new ConstantExpr(xored);
        return new FakeArithmeticExpr(allocExpr, startingExpr, ArithmeticExpr.Operator.XOR);
    }
}