package net.minecraft.server;
import com.google.common.collect.Sets;
import java.util.Set;

public class amu extends aks {

   private static final Set c = Sets.newHashSet(new Block[]{Blocks.cs, Blocks.q, Blocks.e, Blocks.E, Blocks.ah, Blocks.ag, Blocks.T, Blocks.D, Blocks.R, Blocks.o, Blocks.aI, Blocks.S, Blocks.p, Blocks.y, Blocks.x, Blocks.aD, Blocks.Y, Blocks.aV, Blocks.cB, Blocks.av, Blocks.aC, Blocks.A, Blocks.cM, Blocks.b, Blocks.U});


   protected amu(ami var1) {
      super(2.0F, var1, c);
   }

   public boolean b(Block var1) {
      return var1 == Blocks.Z?this.b.d() == 3:(var1 != Blocks.ah && var1 != Blocks.ag?(var1 != Blocks.bP && var1 != Blocks.bT?(var1 != Blocks.R && var1 != Blocks.o?(var1 != Blocks.S && var1 != Blocks.p?(var1 != Blocks.y && var1 != Blocks.x?(var1 != Blocks.aC && var1 != Blocks.aD?(var1.r() == Material.STONE?true:(var1.r() == Material.ORE?true:var1.r() == Material.HEAVY)):this.b.d() >= 2):this.b.d() >= 1):this.b.d() >= 1):this.b.d() >= 2):this.b.d() >= 2):this.b.d() >= 2);
   }

   public float a(ItemStack var1, Block var2) {
      return var2.r() != Material.ORE && var2.r() != Material.HEAVY && var2.r() != Material.STONE?super.a(var1, var2):this.a;
   }

}
