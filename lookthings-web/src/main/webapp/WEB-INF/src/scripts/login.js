/**
 * Created by Fantasy on 2018/1/24.
 */
new Vue({
    el: '#user-login',
    data: function () {
        return {
            form: {
                userName: '',
                password: ''
            },
            rules: {
                userName: [
                    {required: true, message: '账号不能为空', trigger: 'blur'}
                ],
                password: [
                    {required: true, message: '密码不能为空', trigger: 'blur'}
                ]
            }
        }
    },
    methods: {
        handleSubmit: function () {
            this.$refs.loginForm.validate(function (valid) {
                if (valid) {

                }
            });
        }
    }
});
