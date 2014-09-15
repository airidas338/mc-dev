package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.Map;

public class amy extends Item {

   private static final Map b = Maps.newHashMap();
   public final String a;


   protected amy(String var1) {
      this.a = var1;
      this.h = 1;
      this.a(CreativeModeTab.f);
      b.put("records." + var1, this);
   }

   public boolean a(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      IBlockData var9 = var3.getData(var4);
      if(var9.c() == Blocks.JUKEBOX && !((Boolean)var9.b(BlockJukeBox.a)).booleanValue()) {
         if(var3.isStatic) {
            return true;
         } else {
            ((BlockJukeBox)Blocks.JUKEBOX).a(var3, var4, var9, var1);
            var3.a((EntityHuman)null, 1005, var4, Item.b((Item)this));
            --var1.b;
            return true;
         }
      } else {
         return false;
      }
   }

   public amx g(ItemStack var1) {
      return amx.c;
   }

}
