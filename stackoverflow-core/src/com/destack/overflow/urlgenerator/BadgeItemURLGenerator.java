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
public class BadgeItemURLGenerator implements URLGenerator<BadgeItemInitializer> {

    @Override
    public URL urlGenerator(BadgeItemInitializer badgeItemInitializer) throws MalformedURLException {
        String url = "https://api.stackexchange.com/2.2/badges?";
        if (badgeItemInitializer.getPage() != 0) {
            url += "&page=".concat(String.valueOf(badgeItemInitializer.getPage()));
        }
        if (badgeItemInitializer.getPageSize() != 0) {
            url += "&pagesize=".concat(String.valueOf(badgeItemInitializer.getPageSize()));
        }
        if (badgeItemInitializer.getFromDate() != 0) {
            url += "&fromdate=".concat(String.valueOf(badgeItemInitializer.getFromDate()));
        }
        if (badgeItemInitializer.getToDate() != 0) {
            url += "&todate=".concat(String.valueOf(badgeItemInitializer.getToDate()));
        }
        if (badgeItemInitializer.getBr().equals(
                EnumSet.of(BadgeRetriever.NORMAL, BadgeRetriever.NAME, BadgeRetriever.ID, BadgeRetriever.TAG))) {
            if (!badgeItemInitializer.getOrder().toString().isEmpty()) {
                url += "&order=".concat(badgeItemInitializer.getOrder().toString());
            } else {
                url += "&order=".concat(Order.DESC.toString());
            }
            if (badgeItemInitializer.getSort() != null && !badgeItemInitializer.getSort().toString().isEmpty()) {
                url += "&sort=".concat(badgeItemInitializer.getSort().toString());
            } else {
                url += "&sort=".concat(BadgeSortBy.RANK.toString());
            }
            if (badgeItemInitializer.getMin() != null) {
                url += "&min=".concat(badgeItemInitializer.getMin().toString());
            }
            if (badgeItemInitializer.getMax() != null) {
                url += "&max=".concat(badgeItemInitializer.getMax().toString());
            }
            if (badgeItemInitializer.getBr().equals(EnumSet.of(BadgeRetriever.NORMAL, BadgeRetriever.NAME))) {
                if (badgeItemInitializer.getInName() != null && !badgeItemInitializer.getInName().trim().isEmpty()) {
                    url += "&inname=".concat(badgeItemInitializer.getInName());
                }
            }
            url += "&site=stackoverflow&filter=!9YdnSQHcv";
            url = url.replace("?&", "?");
            if (badgeItemInitializer.getBr().equals(BadgeRetriever.NORMAL)) {
                return new URL(url);
            } else if (badgeItemInitializer.getBr().equals(BadgeRetriever.NAME)) {
                url = url.replace("badges", "badges/name");
                return new URL(url);
            } else if (badgeItemInitializer.getBr().equals(BadgeRetriever.ID)
                    && badgeItemInitializer.getBadge_id() != 0) {
                url = url.replace("badges", "badges".concat(String.valueOf(badgeItemInitializer.getBadge_id())));
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
            url += "&site=stackoverflow&filter=!9YdnSQHcv";
            if (url.contains("?&")) {
                url.replace("?&", "?");
            }
            url = url.replace("badges?", "badges/recipients?");
            return new URL(url);
        }
        if (badgeItemInitializer.getBr().equals(BadgeRetriever.ID_RECIPIENT)) {
            if (badgeItemInitializer.getBadge_id() != 0) {
                url = url.replace("badges",
                        "badges/".concat(String.valueOf(badgeItemInitializer.getBadge_id()).concat("/recipients")));
            }
            url += "&site=stackoverflow&filter=!9YdnSQHcv";
            if (url.contains("?&")) {
                url.replace("?&", "?");
            }
            return new URL(url);
        }
        throw new InvalidParameterException("Invalid arguments passed");
    }

}
