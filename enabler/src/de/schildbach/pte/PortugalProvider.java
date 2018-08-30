/*
 * Copyright 2015 the original author or authors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.schildbach.pte;

import de.schildbach.pte.dto.Product;
import de.schildbach.pte.dto.Style;
import de.schildbach.pte.dto.Style.Shape;

import okhttp3.HttpUrl;

/**
 * @author Nicolas Derive
 */
public class PortugalProvider extends AbstractNavitiaProvider {
    private static String API_REGION = "portugal";

    public PortugalProvider(final HttpUrl apiBase, final String authorization) {
        super(NetworkId.PORTUGAL, apiBase, authorization);

        setTimeZone("Europe/Lisbon");
    }

    public PortugalProvider(final String authorization) {
        super(NetworkId.PORTUGAL, authorization);

        setTimeZone("Europe/Lisbon");
    }

    @Override
    public String region() {
        return API_REGION;
    }

    @Override
    protected Style getLineStyle(final String network, final Product product, final String code, final String color) {
        switch (product) {
        case REGIONAL_TRAIN: {
            return new Style(Style.parseColor(color), computeForegroundColor(color));
        }
        case SUBURBAN_TRAIN: {
            return new Style(Style.parseColor(color), computeForegroundColor(color));
        }
        case TRAM: {
            return new Style(Shape.CIRCLE, Style.TRANSPARENT, Style.parseColor(color), Style.parseColor(color));
        }
        case BUS: {
            return new Style(Shape.ROUNDED, Style.parseColor(color), computeForegroundColor(color));
        }
        case FERRY: {
            return new Style(Shape.ROUNDED, Style.parseColor(color), computeForegroundColor(color));
        }
        case SUBWAY: {
            return new Style(Shape.ROUNDED, Style.parseColor(color), computeForegroundColor(color));
        }
        default:
            return super.getLineStyle(network, product, code, color);
        }
    }

    /*
    @Override
    protected String getAddressName(final String name, final String houseNumber) {
        return houseNumber + " " + name;
    }
    */
}
