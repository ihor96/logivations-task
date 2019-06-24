package com.logivations.businessLogics;

import com.logivations.helpers.ConstNumbers;
import com.logivations.models.Case;
import com.logivations.models.Order;
import com.logivations.models.Product;
import java.util.*;
import java.util.stream.Collectors;

public class BusinessLogic {

    public Set<Case> checkByVolume(List<Case> cases, List<Order> orders) {
        Set<Case> checkedListOfCases = new HashSet<>();
        List<Case> sortedCases = cases.stream()
                                      .sorted((o1, o2) -> (int) (o1.getCaseV() - o2.getCaseV()))
                                      .collect(Collectors.toList());
        List<Product> sortedProducts = orders.stream()
                                             .flatMap(order -> order.getProducts()
                                             .stream()
                                             .sorted((o1, o2) -> (int) (o1.getProductV() - o2.getProductV())))
                                             .collect(Collectors.toList());
        for (Product product : sortedProducts) {
            for (Case casee : sortedCases) {
                if (casee.getCaseV() >= product.getProductV()) {
                    casee.setProduct(product);
                    checkedListOfCases.add(casee);
                }
            }
        }
        return checkedListOfCases;
    }

    public List<Case> checkBySizeParameters(Set<Case> cases) {
        List<Case> checkedListOfCases = new LinkedList<>();
        for (Case casee : cases) {
            List<Double> caseValues = new ArrayList<>();
            caseValues.add(casee.getCaseSizeX());
            caseValues.add(casee.getCaseSizeY());
            caseValues.add(casee.getCaseSizeZ());
            caseValues.sort((o1, o2) -> (int) (o1 - o2));
            List<Double> productValues = new ArrayList<>();
            productValues.add(casee.getProduct().getProductSizeX());
            productValues.add(casee.getProduct().getProductSizeY());
            productValues.add(casee.getProduct().getProductSizeZ());
            productValues.sort((o1, o2) -> (int) (o1 - o2));
            if (caseValues.get(ConstNumbers.getFirstElement()) >= productValues.get(ConstNumbers.getFirstElement()) &
                    caseValues.get(ConstNumbers.getSecondElement()) >= productValues.get(ConstNumbers.getSecondElement()) &
                    caseValues.get(ConstNumbers.getThirdElement()) >= productValues.get(ConstNumbers.getThirdElement())) {
                checkedListOfCases.add(casee);
            }
        }
        return checkedListOfCases;
    }
}
