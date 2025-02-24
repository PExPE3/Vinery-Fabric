package satisfyu.vinery.block;

import satisfyu.vinery.item.DrinkBlockItem;
import satisfyu.vinery.registry.StorageTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class FourBottleStorageBlock extends StorageBlock {

    public FourBottleStorageBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canInsertStack(ItemStack stack) {
        return stack.getItem() instanceof DrinkBlockItem;
    }

    @Override
    public int size(){
        return 4;
    }


    @Override
    public Identifier type() {
        return StorageTypes.FOUR_BOTTLE;
    }

    @Override
    public Direction[] unAllowedDirections() {
        return new Direction[]{Direction.DOWN, Direction.UP};
    }


    @Override
    public int getSection(Float x, Float y) {

        if (x > 0.375 && x < 0.625) {
            if(y >= 0.55){
                return  0;
            }
            else if(y <= 0.45) {
                return 3;
            }
        }
        else if(y > 0.35 && y < 0.65){
            if(x < 0.4){
                return 1;
            }
            else if(x > 0.65){
                return 2;
            }
        }

        return Integer.MIN_VALUE;
    }
}
