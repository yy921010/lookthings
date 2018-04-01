/**
 * Created by Fantasy on 2018/1/24.
 */
new Vue({
    el: '#not-found-page',
    methods: {
        backPage: function () {
            this.$router.go(-1);
        },
        goHome: function () {
            location.href = "/user/login"
        }
    }
});