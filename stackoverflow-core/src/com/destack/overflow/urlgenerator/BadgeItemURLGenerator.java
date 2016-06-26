package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.EnumSet;

import com.destack.overflow.enums.BadgeRetriever;
import com.destack.overflow.enums.BadgeSortBy;
import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.BadgeItemInitializer;

/**
 * @author Deepak
 *
 */
public class BadgeItemURLGenerator extends BaseURLComponentGenerator implements URLGenerator<BadgeItemInitializer> {

    @Override
    public URL urlGenerator(BadgeItemInitializer badgeItemInitializer)
            throws MalformedURLException, IllegalAccessException {
        String url = "https://api.stackexchange.com/2.2/badges?";
        if (badgeItemInitializer.getPage() != 0) {
            url += getPageURL(badgeItemInitializer.getPage());
        }
        if (badgeItemInitializer.getPageSize() != 0) {
            url += getPageSizeURL((badgeItemInitializer.getPageSize()));
        }
        if (badgeItemInitializer.getFromDate() != 0) {
            url += getFromDate((badgeItemInitializer.getFromDate()));
        }
        if (badgeItemInitializer.getToDate() != 0) {
            url += getToDate((badgeItemInitializer.getToDate()));
        }
        if (badgeItemInitializer.getBr().equals(BadgeRetriever.NORMAL)
                || badgeItemInitializer.getBr().equals(BadgeRetriever.NAME)
                || badgeItemInitializer.getBr().equals(BadgeRetriever.ID)
                || badgeItemInitializer.getBr().equals(BadgeRetriever.TAG)) {
            if (badgeItemInitializer.getOrder() != null && !badgeItemInitializer.getOrder().toString().isEmpty()) {
                url += getOrder(badgeItemInitializer.getOrder().toString());
            } else {
                url += getOrder(Order.DESC.toString());
            }
            if (badgeItemInitializer.getSort() != null && !badgeItemInitializer.getSort().toString().isEmpty()) {
                url += getSortURLComponent(badgeItemInitializer.getSort().toString());
            } else {
                url += getSortURLComponent(BadgeSortBy.RANK.toString());
            }
            if (badgeItemInitializer.getbMin() != null) {
                url += getMin(badgeItemInitializer.getbMin().toString());
            }
            if (badgeItemInitializer.getbMax() != null) {
                url += getMax(badgeItemInitializer.getbMax().toString());
            }
            if (badgeItemInitializer.getBr().equals(EnumSet.of(BadgeRetriever.NORMAL, BadgeRetriever.NAME))) {
                if (badgeItemInitializer.getInName() != null && !badgeItemInitializer.getInName().trim().isEmpty()) {
                    url += getInNameURLComponent(badgeItemInitializer.getInName());
                }
            }
            url += "&site=stackoverflow&filter=!-*f(6qLMLow-";
            url = urlFixer(url);
            if (badgeItemInitializer.getBr().equals(BadgeRetriever.NORMAL)) {
                return new URL(url);
            } else if (badgeItemInitializer.getBr().equals(BadgeRetriever.NAME)) {
                url = url.replace("badges", "badges/name");
                return new URL(url);
            } else if (badgeItemInitializer.getBr().equals(BadgeRetriever.ID)
                    && badgeItemInitializer.getBadge_id() != 0) {
                url = url.replace("badges", "badges/".concat(String.valueOf(badgeItemInitializer.getBadge_id())));
                return new URL(url);
            } else if (badgeItemInitializer.getBr().equals(BadgeRetriever.TAG)) {
                url = url.replace("badges", "badges/tags");
                return new URL(url);
            } else if (badgeItemInitializer.getBadge_id() != 0) {
                url = url.replace("badges", "badges/".concat(String.valueOf(badgeItemInitializer.getBadge_id())));
                return new URL(url);
            }
        }
        if (badgeItemInitializer.getBr().equals(BadgeRetriever.RECIPIENT)) {
            url = urlFixer(url);
            url += "&filter=!-*f(6qLMLow-";
            url = url.replace("badges?", "badges/recipients?");
            return new URL(url);
        }
        if (badgeItemInitializer.getBr().equals(BadgeRetriever.ID_RECIPIENT)) {
            if (badgeItemInitializer.getBadge_id() != 0) {
                url = url.replace("badges",
                        "badges/".concat(String.valueOf(badgeItemInitializer.getBadge_id()).concat("/recipients")));
            } else {
                throw new IllegalAccessException("ID should not be zero");
            }
            url += "&site=stackoverflow&filter=!-*f(6qLMLow-";
            url = urlFixer(url);
            return new URL(url);
        }
        throw new InvalidParameterException("Invalid arguments passed");
    }

}
