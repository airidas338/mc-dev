package net.minecraft.server;
import com.google.common.collect.Sets;
import java.util.Set;

public class ane extends aks {

   private static final Set c = Sets.newHashSet(new Block[]{Blocks.aL, Blocks.d, Blocks.ak, Blocks.c, Blocks.n, Blocks.bw, Blocks.m, Blocks.aJ, Blocks.aH, Blocks.aW});


   public ane(ami var1) {
      super(1.0F, var1, c);
   }

   public boolean b(Block var1) {
      return var1 == Blocks.aH?true:var1 == Blocks.aJ;
   }

}
