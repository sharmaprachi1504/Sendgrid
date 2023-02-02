#! /usr/bin/env node

const sgMail = require('@sendgrid/mail');
sgMail.setApiKey('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');

const msg = {
    to: 'sharmaprachi1504@gmail.com',
    from: 'prachi.sharma01@nagarro.com',
    subject: 'Hello world',
    text: 'Hello plain world!',
    html: '<p>Hello HTML world!</p>',
};

sgMail
    .send(msg)
    .then(() => console.log('Mail sent successfully'))
    .catch(error => console.error(error.toString()));
