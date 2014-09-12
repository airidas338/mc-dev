package net.minecraft.server;
import java.util.Collection;

public abstract class ScoreboardTeamBase {

   public boolean a(ScoreboardTeamBase var1) {
      return var1 == null?false:this == var1;
   }

   public abstract String b();

   public abstract String d(String var1);

   public abstract boolean g();

   public abstract Collection d();

   public abstract bsg j();
}
