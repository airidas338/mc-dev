package net.minecraft.server;
import com.google.common.collect.Sets;
import java.util.Set;

public class ItemSpade extends aks {

   private static final Set c = Sets.newHashSet(new Block[]{Blocks.CLAY, Blocks.DIRT, Blocks.SOIL, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCEL, Blocks.SAND, Blocks.SNOW_BLOCK, Blocks.SNOW, Blocks.SOUL_SAND});


   public ItemSpade(EnumToolMaterial var1) {
      super(1.0F, var1, c);
   }

   public boolean canDestroySpecialBlocks(Block var1) {
      return var1 == Blocks.SNOW?true:var1 == Blocks.SNOW_BLOCK;
   }

}
