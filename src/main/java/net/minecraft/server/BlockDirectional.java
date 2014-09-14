package net.minecraft.server;
import com.google.common.base.Predicate;

public abstract class BlockDirectional extends Block {

   public static final beu N = beu.a("facing", (Predicate)en.a);


   protected BlockDirectional(Material var1) {
      super(var1);
   }

}
