/*
 * PlotSquared, a land and world management plugin for Minecraft.
 * Copyright (C) IntellectualSites <https://intellectualsites.com>
 * Copyright (C) IntellectualSites team and contributors
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
package com.plotsquared.core.plot;

import com.plotsquared.core.configuration.caption.Caption;
import com.plotsquared.core.configuration.caption.TranslatableCaption;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PlotShape {
    SQUARE(TranslatableCaption.of("plotshape.plot_shape_square")),
    CROSS(TranslatableCaption.of("plotshape.plot_shape_cross"));

    private static final Map<String, PlotShape> shapes = Stream.of(values())
            .collect(Collectors.toMap(e -> e.toString().toLowerCase(), Function.identity()));
    private final Caption description;

    PlotShape(final @NonNull Caption description) {
        this.description = description;
    }

    public static Map<PlotShape, Caption> getDescriptionMap() {
        return Stream.of(values()).collect(Collectors.toMap(e -> e, PlotShape::getDescription));
    }

    public static Optional<PlotShape> fromString(String shapeName) {
        return Optional.ofNullable(shapes.get(shapeName.toLowerCase()));
    }

    public Caption getDescription() {
        return this.description;
    }
}
