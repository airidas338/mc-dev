package net.minecraft.server;
import com.google.common.collect.Sets;
import java.util.Set;

public class ItemAxe extends aks {

   private static final Set c = Sets.newHashSet(new Block[]{Blocks.WOOD, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.JACK_O_LANTERN, Blocks.MELON, Blocks.LADDER});


   protected ItemAxe(EnumToolMaterial var1) {
      super(3.0F, var1, c);
   }

   public float a(ItemStack var1, Block var2) {
      return var2.getMaterial() != Material.WOOD && var2.getMaterial() != Material.PLANT && var2.getMaterial() != Material.REPLACAEBLE_PLAN?super.a(var1, var2):this.a;
   }

}
