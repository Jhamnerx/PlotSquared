# Cross-Shaped Plots Feature

## Overview

This feature adds support for creating cross-shaped plots (plots in the shape of a plus sign "+") in PlotSquared. This is particularly useful for partial plot areas where you want a distinctive plot shape.

## Usage

### Creating a Cross-Shaped Plot Area

To create a plot area with cross-shaped plots, use the `/plot area create` command with the `shape=cross` parameter:

```
/plot area create world:myarea shape=cross type=partial
```

### Available Parameters

When creating a plot area, you can combine the shape parameter with other modifiers:

- `shape=cross` - Sets the plot shape to cross (default is `square`)
- `type=partial` - Creates a partial plot area (required for custom shapes in existing worlds)
- `size=<number>` - Sets the plot width (default is typically 32)
- `gap=<number>` - Sets the road width between plots
- `height=<number>` - Sets the plot height
- Other standard PlotSquared area parameters

### Example Commands

1. **Create a partial cross-shaped plot area:**
   ```
   /plot area create world:crosses shape=cross type=partial size=42 gap=7
   ```

2. **Set position 1 (after running the create command):**
   ```
   /plot area create pos1
   ```

3. **Set position 2 to complete the area creation:**
   ```
   /plot area create pos2
   ```

## How Cross-Shaped Plots Work

Cross-shaped plots are divided into thirds both horizontally and vertically:
- The center vertical third (columns) extends the full height
- The center horizontal third (rows) extends the full width
- The four corner areas are not part of the plot

This creates a distinctive plus-sign shape that can be useful for:
- Themed builds (e.g., hospitals with red cross symbol)
- Unique plot layouts
- Creative server designs

## Configuration

The shape is automatically saved in the world configuration file under:
```yaml
plot:
  shape: cross
```

For square plots (default), this setting can be omitted or set to `square`.

## Compatibility

Cross-shaped plots work with:
- Plot claiming
- Plot clearing
- Plot teleportation
- Plot flags and permissions
- WorldEdit region selection (returns multiple regions for the cross shape)

## Notes

- **Important**: Cross-shaped plots work best with plot widths divisible by 3. If the width is not divisible by 3, integer division will be used, which may result in slightly uneven cross shapes. Recommended widths: 30, 33, 36, 39, 42, 45, etc.
- Cross-shaped plots are calculated based on the plot width divided into thirds
- Players standing in the corner areas (outside the cross) will not be considered inside the plot
- Merging cross-shaped plots is supported and will maintain the cross pattern for individual plots, with roads included in merged regions
