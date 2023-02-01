#! /usr/bin/env node

const sgMail = require('@sendgrid/mail');
sgMail.setApiKey(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);

const msg = {
    to: 'narendra.kumar02@nagarro.com',
    from: 'rexzoneandothers@gmail.com',
    subject: 'Hello world',
    text: 'Hello plain world!',
    html: '<p>Hello HTML world!</p>',
};

sgMail
    .send(msg)
    .then(() => console.log('Mail sent successfully'))
    .catch(error => console.error(error.toString()));
