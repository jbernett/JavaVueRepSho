<template>
  <div>
    <b-container>
      <b-row>
        <b-col> </b-col>
        <b-col>
          <b-card          
            tag="article"
            style="max-width: 20rem"
            class="mb-2"
          >
            <b-card-text>
               <img class="welcome-image" alt="welcome" src="@/assets/welcome.jpg">
              <ValidationObserver v-slot="{ handleSubmit }">
                <form name="form" @submit.prevent="handleSubmit(submit)">
                  <div v-if="!successful">
                    <div class="form-group">
                      <label for="username">Username</label>
                      <validation-provider
                        name="field"
                        rules="required|min:3|max:20"
                        v-slot="{ errors }"
                      >
                        <input
                          v-model="user.username"
                          type="text"
                          class="form-control"
                          name="username"
                        />
                        <span>{{ errors[0] }}</span>
                      </validation-provider>
                    </div>
                    <div class="form-group">
                      <label for="email">Email</label>
                      <validation-provider
                        name="field"
                        rules="required|email|max:50"
                        v-slot="{ errors }"
                      >
                        <input
                          v-model="user.email"
                          type="email"
                          class="form-control"
                          name="email"
                        />
                        <span>{{ errors[0] }}</span>
                      </validation-provider>
                    </div>
                    <div class="form-group">
                      <label for="password">Password</label>
                      <validation-provider
                        name="password"
                        rules="required|min:6|max:40"
                        v-slot="{ errors }"
                      >
                        <input
                          v-model="user.password"
                          type="password"
                          class="form-control"
                          name="password"
                        />
                        <span>{{ errors[0] }}</span>
                      </validation-provider>
                    </div>

                    <div class="form-group">
                      <b-btn type="submit" variant="dark">Sign Up</b-btn>
                    </div>
                  </div>
                </form>
              </ValidationObserver>
            </b-card-text>
          </b-card>
        </b-col>
        <b-col> </b-col>
      </b-row>
    </b-container>

    <div
      v-if="message"
      class="alert"
      :class="successful ? 'alert-success' : 'alert-danger'"
    >
      {{ message }}
    </div>
  </div>
</template>

<script>
import User from "@/models/user";

export default {
  name: "Register",
  data() {
    return {
      user: new User("", "", ""),
      submitted: false,
      successful: false,
      message: "",
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  mounted() {
    if (this.loggedIn) {
      this.$router.push("/profile");
    }
  },
  methods: {
    submit() {
      this.message = "";
      this.submitted = true;
      this.$store.dispatch("auth/register", this.user).then((data) => {
        this.message = data.message;
        this.successful = true;
      });
    },
  },
};
</script>

<style scoped>
.card {
  box-shadow:
  0 2.8px 2.2px rgba(0, 0, 0, 0.034),
  0 6.7px 5.3px rgba(0, 0, 0, 0.048),
  0 12.5px 10px rgba(0, 0, 0, 0.06),
  0 22.3px 17.9px rgba(0, 0, 0, 0.072),
  0 41.8px 33.4px rgba(0, 0, 0, 0.086),
  0 100px 80px rgba(0, 0, 0, 0.12)
}
.welcome-image {
  max-width: -webkit-fill-available;
  filter: hue-rotate(300deg);
    -webkit-filter: hue-rotate(300deg);
}
</style>