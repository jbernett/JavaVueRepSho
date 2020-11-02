<template>
  <div>    
    <Burger :isBurgerActive=isBurgerActive v-on:clickedBurger="clickedBurger()"></Burger>
    <b-sidebar id="sidebar-no-header" aria-labelledby="sidebar-no-header-title" no-header shadow v-on:change="clickedBurger()">
      <template #default="{ hide }">
        <div class="p-3">
          <h4 id="sidebar-no-header-title">Repsho</h4>
          <nav class="mb-3">
            <b-nav vertical>
                <b-nav-item to="/" exact exact-active-class="active"  @click="hide">Home</b-nav-item>
                <b-nav-item to="/about" exact exact-active-class="active" @click="hide">About</b-nav-item>
                <b-nav-item to="/ingredients" exact exact-active-class="active" @click="hide">Ingredients</b-nav-item>
            </b-nav>
          </nav>          
        </div>
      </template>
    </b-sidebar>
  </div>
</template>
<script>
import Burger from './Burger.vue'

export default {
  name: 'App',
  components: {
    Burger
  },
  props: {
      isBurgerActive : Boolean
  },
  methods : {
      clickedBurger () {          
          this.$emit('clickedBurger');
    } 
  }
}

</script>