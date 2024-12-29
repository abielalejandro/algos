package com.varios;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.*;

public class Agrupar {

    public static void main(String[] args) {
        System.out.println("Hola");

        List<Test> orders = Arrays.asList(
                new Test("001","001/001/001","001","001","MCN","MCN"),
                new Test("001","001/001/002","001","002","MCN","MCN"),
                new Test("001","001/001/003","001","003","MCN","MCN"),
                new Test("001","001/001/003","001","003","REBL","REBL"),
                new Test("001","001/001/003","002","001","REBL","REBL"),
                new Test("001","001/001/003","002","001","MCN","MCN")
        );

        List<Test> ordersUk = orders.stream().distinct().collect(toList());

        System.out.println(ordersUk);

            Map<String, List<String>> groups = orders.stream()
                    .collect(
                            groupingBy((t)->{
                        var s = new StringBuilder(t.orderNum).append(t.getSourceCode());
                        return s.toString();
                    },mapping(Test::getPartReturnNum, toList())) );

        System.out.println(groups);
    }

    static class Test{

        public String truckId;
        public String truckIdOrderNumPartReturnNum;
        public String orderNum;
        public String partReturnNum;
        public String sourceName;
        public String sourceCode;

        public Test(String truckId,String truckIdOrderNumPartReturnNum, String orderNum, String partReturnNum, String sourceName, String sourceCode) {
            this.truckId = truckId;
            this.truckIdOrderNumPartReturnNum = truckIdOrderNumPartReturnNum;
            this.orderNum = orderNum;
            this.partReturnNum = partReturnNum;
            this.sourceName = sourceName;
            this.sourceCode = sourceCode;
        }

        public String getTruckId() {
            return truckId;
        }

        public String getTruckIdOrderNumPartReturnNum() {
            return truckIdOrderNumPartReturnNum;
        }

        public String getPartReturnNum() {
            return partReturnNum;
        }

        public String getSourceName() {
            return sourceName;
        }

        public String getSourceCode() {
            return sourceCode;
        }

        public String getOrderNum() {
            return this.orderNum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Test test = (Test) o;
            return Objects.equals(truckId, test.truckId)
                   && Objects.equals(orderNum, test.orderNum)
                    && Objects.equals(sourceName, test.sourceName)
                    && Objects.equals(sourceCode, test.sourceCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(truckId, orderNum, sourceName, sourceCode);
        }

        @Override
        public String toString() {
            return "Test{" +
                    "truckId='" + truckId + '\'' +
                    ", orderNum='" + orderNum + '\'' +
                    ", sourceName='" + sourceName + '\'' +
                    ", sourceCode='" + sourceCode + '\'' +
                    '}';
        }
    }
}
