package io.eelo.spot.answerers;

import io.eelo.spot.data.Params;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Statistics implements Answerer {

    @Override
    public String[] getKeyWorlds() {
        return new String[]{"min", "max", "avg", "sum", "prod"};
    }

    @Override
    public boolean match(final Params params) {
        final String[] split = params.getQuery().split(" ");
        return split.length > 1 && startQueryWithKeyWord(split) && isNumbers(split);
    }

    private boolean startQueryWithKeyWord(final String[] split) {
        return Arrays.asList(getKeyWorlds()).contains(split[0]);
    }

    private boolean isNumbers(final String[] split) {
        for (int i = 1; i < split.length; i++) {
            try {
                new BigDecimal(split[i]);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private List<BigDecimal> generateNumbers(final String query) {
        final String[] split = query.split(" ");
        final List<BigDecimal> numbers = new ArrayList<>();
        for (int i = 1; i < split.length; i++) {
            numbers.add(new BigDecimal(split[i]));
        }
        return numbers;
    }

    private BigDecimal min(final List<BigDecimal> numbers) {
        BigDecimal result = numbers.get(0);
        for (BigDecimal number : numbers) {
            result = result.min(number);
        }
        return result;
    }

    private BigDecimal max(final List<BigDecimal> numbers) {
        BigDecimal result = numbers.get(0);
        for (BigDecimal number : numbers) {
            result = result.max(number);
        }
        return result;
    }

    private BigDecimal sum(final List<BigDecimal> numbers) {
        BigDecimal result = BigDecimal.ZERO;
        for (BigDecimal number : numbers) {
            result = result.add(number);
        }
        return result;
    }

    private BigDecimal avg(final List<BigDecimal> numbers) {
        return sum(numbers).divide(new BigDecimal(numbers.size()));
    }

    private BigDecimal prod(final List<BigDecimal> numbers) {
        BigDecimal result = BigDecimal.ONE;
        for (BigDecimal number : numbers) {
            result = result.multiply(number);
        }
        return result;
    }

    @Override
    public String call(final Params params) {
        final String keyword = params.getQuery().split(" ")[0];
        final List<BigDecimal> numbers = generateNumbers(params.getQuery());

        switch (keyword) {
            case "min":
                return min(numbers).toString();
            case "max":
                return max(numbers).toString();
            case "avg":
                return avg(numbers).toString();
            case "sum":
                return sum(numbers).toString();
            case "prod":
                return prod(numbers).toString();
        }
        return null;
    }

    @Override
    public String getName() {
        return "Statistics functions";
    }

    @Override
    public String getDescription() {
        return "Compute min/max/avg/sum/prod of the arguments";
    }

    @Override
    public String getExample() {
        return "avg 123 548 2.04 24.2";
    }
}
