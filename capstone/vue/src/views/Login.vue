<template>
  <div id="login" class="text-center">
    <form class="form-sign-in" @submit.prevent="login">
      <h1 class="card-title">Start Your Ride.</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <div class="controls">
        <button class="sign-in-btn" type="submit">Sign in</button>
        <router-link class="reg-link" :to="{ name: 'register' }"
          >Need an account?</router-link
        >
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
.card-title {
  padding: 10px;
}

#login {
  margin: auto;
  background-color: #9bcea8;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  background-image: blur;
  border-radius: 12px;
  width: 70%;
  max-width: 500px;
  box-shadow: 2px 10px 20px darkgrey;
}

.form-sign-in {
  display: flex;
  flex-direction: column;
  padding: 20px;
  justify-content: space-around;
}

.sr-only {
  padding: 5px;
  text-align: left;
  justify-content: space-evenly;
}

.form-control {
  border-radius: 5px;
}

.controls {
  display: flex;
  flex-direction: row;
  margin-top: 15px;
  justify-content: space-between;
}

.sign-in-btn {
  justify-self: left;
  width: 80px;
}
</style>

