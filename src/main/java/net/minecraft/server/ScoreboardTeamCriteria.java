package net.minecraft.server;
import java.util.List;

public class ScoreboardTeamCriteria implements IScoreboardCriteria {

   private final String j;


   public ScoreboardTeamCriteria(String var1, EnumChatFormat var2) {
      this.j = var1 + var2.e();
      IScoreboardCriteria.criteria.put(this.j, this);
   }

   public String getName() {
      return this.j;
   }

   public int a(List var1) {
      return 0;
   }

   public boolean isReadOnly() {
      return false;
   }

   public EnumObjectiveValue c() {
      return EnumObjectiveValue.INTEGER;
   }
}
