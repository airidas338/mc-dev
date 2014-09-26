package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.Map;

public class ItemRecord extends Item {

   private static final Map b = Maps.newHashMap();
   public final String a;


   protected ItemRecord(String var1) {
      this.a = var1;
      this.maxStackSize = 1;
      this.a(CreativeModeTab.f);
      b.put("records." + var1, this);
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      IBlockData var9 = var3.getData(var4);
      if(var9.c() == Blocks.JUKEBOX && !((Boolean)var9.b(BlockJukeBox.a)).booleanValue()) {
         if(var3.isStatic) {
            return true;
         } else {
            ((BlockJukeBox)Blocks.JUKEBOX).a(var3, var4, var9, var1);
            var3.a((EntityHuman)null, 1005, var4, Item.getId((Item)this));
            --var1.count;
            return true;
         }
      } else {
         return false;
      }
   }

   public EnumItemRarity g(ItemStack var1) {
      return EnumItemRarity.RARE;
   }

}
