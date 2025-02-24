package daniking.vinery.recipe;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import daniking.vinery.registry.VineryRecipeTypes;
import daniking.vinery.util.VineryUtils;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class WoodFiredOvenRecipe implements Recipe<Container> {

    protected final ResourceLocation id;
    protected final NonNullList<Ingredient> inputs;
    protected final ItemStack output;
    protected final float experience;

    public WoodFiredOvenRecipe(ResourceLocation id, NonNullList<Ingredient> inputs, ItemStack output, float experience) {
        this.id = id;
        this.inputs = inputs;
        this.output = output;
        this.experience = experience;
    }

    @Override
    public boolean matches(Container inventory, Level world) {
        return VineryUtils.matchesRecipe(inventory, inputs, 0, 2);
    }


    @Override
    public ItemStack assemble(Container inventory) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.inputs;
    }

    @Override
    public ItemStack getResultItem() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }


    public float getExperience() {
        return experience;
    }

    public NonNullList<Ingredient> getInputs() {
        return inputs;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return VineryRecipeTypes.WOOD_FIRED_OVEN_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return VineryRecipeTypes.WOOD_FIRED_OVEN_RECIPE_TYPE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static class Serializer implements RecipeSerializer<WoodFiredOvenRecipe> {

        @Override
        public WoodFiredOvenRecipe fromJson(ResourceLocation id, JsonObject json) {
            final var ingredients = VineryUtils.deserializeIngredients(GsonHelper.getAsJsonArray(json, "ingredients"));
            if (ingredients.isEmpty()) {
                throw new JsonParseException("No ingredients for StoveCooking Recipe");
            } else if (ingredients.size() > 3) {
                throw new JsonParseException("Too many ingredients for StoveCooking Recipe");
            } else {
                final ItemStack outputStack = ShapedRecipe.itemStackFromJson(json);
                float xp = GsonHelper.getAsFloat(json, "experience", 0.0F);
                return new WoodFiredOvenRecipe(id, ingredients, outputStack, xp);

            }

        }


        @Override
        public WoodFiredOvenRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            final var ingredients  = NonNullList.withSize(buf.readVarInt(), Ingredient.EMPTY);
            ingredients.replaceAll(ignored -> Ingredient.fromNetwork(buf));
            final ItemStack output = buf.readItem();
            final float xp = buf.readFloat();
            return new WoodFiredOvenRecipe(id, ingredients, output, xp);
        }

        @Override
        public void write(FriendlyByteBuf packet, WoodFiredOvenRecipe recipe) {
            packet.writeVarInt(recipe.inputs.size());
            recipe.inputs.forEach(entry -> entry.toNetwork(packet));
            packet.writeItem(recipe.output);
            packet.writeFloat(recipe.experience);
        }
    }
}
