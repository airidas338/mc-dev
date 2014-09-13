package net.minecraft.server;
import java.util.Comparator;

final class bsb implements Comparator {

   public int a(ScoreboardScore var1, ScoreboardScore var2) {
      return var1.getScore() > var2.getScore()?1:(var1.getScore() < var2.getScore()?-1:var2.e().compareToIgnoreCase(var1.e()));
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.a((ScoreboardScore)var1, (ScoreboardScore)var2);
   }
}
