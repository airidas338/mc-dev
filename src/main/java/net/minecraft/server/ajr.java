package net.minecraft.server;
import com.google.common.collect.Sets;
import java.util.Set;

public class ajr extends aks {

   private static final Set c = Sets.newHashSet(new Block[]{Blocks.WOOD, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.JACK_O_LANTERN, Blocks.MELON, Blocks.LADDER});


   protected ajr(ami var1) {
      super(3.0F, var1, c);
   }

   public float a(ItemStack var1, Block var2) {
      return var2.r() != Material.WOOD && var2.r() != Material.PLANT && var2.r() != Material.REPLACAEBLE_PLAN?super.a(var1, var2):this.a;
   }

}
