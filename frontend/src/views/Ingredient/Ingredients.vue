<template>
  <div id="ingredients">
    <b-container>
      <b-row class="justify-content-md-center">
        <b-col lg="6">
          <b-button size="sm" block variant="success" class="mr-2" @click="addIngredient"><b-icon icon="plus" animation="throb"></b-icon> Add</b-button>
          <b-table :items="items" :fields="fields" :tbody-tr-class="rowClass">
            <template v-slot:cell(actions)>
              <b-button size="sm" variant="warning" class="mr-2"><b-icon icon="pencil"></b-icon> Edit</b-button>
              <b-button size="sm" variant="danger" class="mr-2"><b-icon icon="trash"></b-icon> Delete</b-button>
            </template>
          </b-table>
        </b-col>
      </b-row>
    </b-container>
    <b-modal 
    :title="ingredientModalTitle" 
    id="ingredientModal"
    ref="modal"
    v-model="showIngredientModal"
    @ok="handleAddIngredient" 
    @hidden="resetModal" 
    @show="resetModal">
      <form ref="form" @submit.stop.prevent="handleSubmit">
        <b-form-group
          :state="nameState"
          label="Name"
          label-for="name-input"
          invalid-feedback="Name is required"
        >
          <b-form-input
            id="name-input"
            v-model="name"
            :state="nameState"
            required
          ></b-form-input>
        </b-form-group>
      </form>
    </b-modal>
  </div>
</template>

<script>
import api from "./IngredientApi";

export default {
  name: 'Ingredients',
  data() {
    return {
      name: "",
      nameState: null,
      showIngredientModal: false,
      ingredientModalTitle: "",
      perPage: 3,
      currentPage: 1,
      fields: ["Id", "Name", "actions"],
      items: [],
    };
  },
  created() {
    this.getAllIngredients();
  },
  computed: {
    rows() {
      return this.items.length;
    },
  },
  methods: {
    rowClass(item, type) {
      if (!item || type !== "row") return;
      if (item.name === "Tomatos") return "table-success";
    },
    addIngredient(){
      this.ingredientModalTitle = "Add Ingredient";
      this.showIngredientModal = true;
    },
    handleAddIngredient(e){
      e.preventDefault();
      this.handleSubmit();
    },
    handleSubmit(){
      if(!this.checkFormValidity()){
        return;
      }
      api.createNew(this.name).then(() => {
        this.getAllIngredients();
      });      
      this.$nextTick(() => this.showIngredientModal = false)
    },
    checkFormValidity(){
      const valid = this.$refs.form.checkValidity();
      this.nameState = valid;
      return valid;
    },
    resetModal(){
      this.name = '';
      this.nameState = null;
    },
    getAllIngredients(){
      api.getAll().then((response) => {
      console.log(response);
      this.items = response.data;
    });
    }
  },
};
</script>
