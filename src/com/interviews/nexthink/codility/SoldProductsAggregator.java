package com.interviews.nexthink.codility;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldProductsAggregator {

    private final EURExchangeService exchangeService;

    SoldProductsAggregator(EURExchangeService EURExchangeService) {
        this.exchangeService = EURExchangeService;
    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {
        List<SimpleSoldProduct> simpleProducts = products
                .map(this::toSimpleSoldProduct)
                .filter(simpleSoldProduct -> simpleSoldProduct==null)
                .collect(Collectors.toList());
        BigDecimal total = simpleProducts.stream()
                .map(simpleProduct -> simpleProduct.getPrice().orElse(BigDecimal.ZERO))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new SoldProductsAggregate(simpleProducts, total);
    }
    private SimpleSoldProduct toSimpleSoldProduct(SoldProduct product) {
        Optional<BigDecimal> rateOpt = exchangeService.rate(product.getCurrency());
        if (rateOpt.isPresent()) {
            return new SimpleSoldProduct(
                    product.getName(),
                    product.getPrice().multiply(rateOpt.get()).setScale(2, BigDecimal.ROUND_HALF_UP));
        }
        return null;
    }

//    private Stream<SimpleSoldProduct> toSimpleSoldProduct1(SoldProduct product) {
//        return exchangeService.rate(product.getCurrency())
//                .filter(rate -> rate.compareTo(BigDecimal.ZERO) > 0)
//                .map(rate -> new SimpleSoldProduct(
//                        product.getName(),
//                        product.getPrice().multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP)
//                ))
//                .map(Optional::ofNullable)
//                .orElseGet(Stream::empty);
//    }

    interface ExchangeService {
        Optional<BigDecimal> rate(String currency);
    }

    static class SoldProduct {
        private final String name;
        private final BigDecimal price;
        private final String currency;

        public SoldProduct(String name, BigDecimal price, String currency) {
            this.name = Objects.requireNonNull(name);
            this.price = Objects.requireNonNull(price);
            this.currency = Objects.requireNonNull(currency);
        }

        public String getName() {
            return name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public String getCurrency() {
            return currency;
        }
    }

    static class SoldProductsAggregate {
        private final List<SimpleSoldProduct> products;
        private final BigDecimal total;

        public SoldProductsAggregate(List<SimpleSoldProduct> products, BigDecimal total) {
            this.products = Objects.requireNonNull(products);
            this.total = Objects.requireNonNull(total);
        }

        public List<SimpleSoldProduct> getProducts() {
            return products;
        }

        public BigDecimal getTotal() {
            return total;
        }
    }

    static class SimpleSoldProduct {
        private final String name;
        private final BigDecimal price;

        public SimpleSoldProduct(String name, BigDecimal price) {
            this.name = Objects.requireNonNull(name);
            this.price = Objects.requireNonNull(price);
        }

        public String getName() {
            return name;
        }

        public Optional<BigDecimal> getPrice() {
            return Optional.ofNullable(price);
        }
    }
}

interface ExchangeService {
    Optional<BigDecimal> rate(String currency);
}

class EURExchangeService implements ExchangeService {

    @Override
    public Optional<BigDecimal> rate(String currency) {
        if (currency.equals("INR")) return Optional.of(new BigDecimal(85.50));
        return Optional.empty();
    }
}