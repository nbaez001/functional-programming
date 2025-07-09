package com.empresa.proyecto.designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class StrategyPattern {
    public static void main(String[] args) {
        List<Stock> stockList = new ArrayList<>();
        stockList.add(new Stock("AAPL", 318.65, 10));
        stockList.add(new Stock("MSFT", 166.86, 45));
        stockList.add(new Stock("GOOGLE", 99, 12.5));
        stockList.add(new Stock("AMZ", 1866.74, 45));
        stockList.add(new Stock("GOOGL", 1480.20, 3.5));
        stockList.add(new Stock("AAPL", 318.65, 8));
        stockList.add(new Stock("AMZ", 1866.74, 9));

        StockFilters.bySymbol(stockList, "AMZ").forEach(System.out::println);
    }
}

class StockFilters {
    public static List<Stock> bySymbol(List<Stock> list, String symbol) {
        List<Stock> filteredData = new ArrayList<>();
        for (Stock stock : list) {
            if (stock.getSymbol().equals(symbol)) {
                filteredData.add(stock);
            }
        }
        return filteredData;
    }

    public static List<Stock> byPriceAbove(List<Stock> list, double price) {
        List<Stock> filteredData = new ArrayList<>();
        for (Stock stock : list) {
            if (stock.getPrice() > price) {
                filteredData.add(stock);
            }
        }
        return filteredData;
    }
}

class Stock {
    private String symbol;
    private double price;
    private double units;

    public Stock(String symbol, double price, double units) {
        this.symbol = symbol;
        this.price = price;
        this.units = units;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getUnits() {
        return units;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                ", units=" + units +
                '}';
    }
}