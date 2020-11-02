<template>
  <div id="app">
      <Sidebar :isBurgerActive=isBurgerActive v-on:clickedBurger="clickedBurger()"/>
    <router-view/>
  </div>
</template>
<script>
import Sidebar from '@/components/SideNavBar.vue';

export default {  
  components: {
    Sidebar
  },
  data(){
    return {
      isBurgerActive: false
    }
  },
  methods: {
    clickedBurger(){
      this.isBurgerActive = !this.isBurgerActive
    }
  }
}
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
