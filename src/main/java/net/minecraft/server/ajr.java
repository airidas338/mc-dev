package net.minecraft.server;
import com.google.common.collect.Sets;
import java.util.Set;

public class ajr extends aks {

   private static final Set c = Sets.newHashSet(new Block[]{aty.f, aty.X, aty.r, aty.s, aty.ae, aty.aU, aty.aZ, aty.bk, aty.au});


   protected ajr(ami var1) {
      super(3.0F, var1, c);
   }

   public float a(amj var1, Block var2) {
      return var2.r() != Material.d && var2.r() != Material.k && var2.r() != Material.l?super.a(var1, var2):this.a;
   }

}
