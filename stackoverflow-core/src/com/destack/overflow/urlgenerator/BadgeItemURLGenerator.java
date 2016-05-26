package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

import com.destack.overflow.enums.BadgeSortBy;
import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.BadgeItemInitializer;

/**
 * @author Deepak
 *
 */
public class BadgeItemURLGenerator implements URLGenerator<BadgeItemInitializer> {

    String url = "&order=desc&min=gold&max=silver&sort=rank&site=stackoverflow&filter=!9YdnSQHcv";

    @Override
    public URL urlGenerator(BadgeItemInitializer badgeItemInitializer) throws MalformedURLException {
        String url = "https://api.stackexchange.com/2.2/badges?";
        if (badgeItemInitializer.getBadge_id() != 0) {
            return new URL(urlGenerator(badgeItemInitializer, url).replace("", ""));
        }
        return null;
    }

    public String urlGenerator(BadgeItemInitializer badgeItemInitializer, String url) throws MalformedURLException {
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
        if (badgeItemInitializer.getMin()!=null&&!badgeItemInitializer.getMin().isEmpty()) {
            url += "&min=".concat(badgeItemInitializer.getMin());
        }
        if (badgeItemInitializer.getMax() != null&&!badgeItemInitializer.getMax().isEmpty()) {
            url += "&max=".concat(String.valueOf(badgeItemInitializer.getMax()));
        }
        url += "&site=stackoverflow&filter=!9YdnSQHcv";
        url = url.replace("https://api.stackexchange.com/2.2/badges?&", "https://api.stackexchange.com/2.2/badges?");
        return url;
    }
}
