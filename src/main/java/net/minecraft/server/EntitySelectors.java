package net.minecraft.server;

import com.google.common.base.Predicate;

public final class EntitySelectors {

   public static final Predicate a = new PredicateAlive();
   public static final Predicate b = new PredicateSingluarAliveEntity();
   public static final Predicate c = new PredicateAliveInventory();
   public static final Predicate d = new PredicateNonSpectating();


}
