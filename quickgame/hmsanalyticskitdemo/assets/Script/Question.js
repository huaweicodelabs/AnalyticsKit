/*
 * Copyright 2021. Huawei Technologies Co., Ltd. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
cc.Class({
  extends: cc.Component,

  properties: {
    finishPanel: cc.Node,
    answerPanel: cc.Node,
    questionIndexLabel: cc.Label,
    questionContentLabel: cc.Label
  },

  // use this for initialization
  onLoad: function() {
    this.questionTotal = 5
    this.questionIndex = 0
    this.score = 0
    this.answers = [true, true, false, false, true]
    this.questions = [
      'The largest planet in the solar system is Jupiter',
      'The first Olympic Games were held in Athens, Greece',
      'The violin has 6 strings',
      'Flying bats belong to birds',
      'Sound spreads faster in the water than in the air'
    ]
    this.isAnswerFinished = false
    this.userAnswers = new Array(this.questionTotal);

    this.showQuestion()
  },

  clickBtnSettings() {
    cc.director.loadScene("setting")
  },

  clickBtnResult() {
    cc.director.loadScene("result")
  },

  clickBtnAnswer(target, answer) {
    if (answer == this.answers[this.questionIndex].toString()) {
      this.score += 100 / this.questionTotal
    }

    this.userAnswers[this.questionIndex] = answer === 'true'
    this.reportAnswer(answer)
    this.goNext()
  },
  goNext() {
    this.questionIndex++
    this.isAnswerFinished = this.questionIndex >= this.questionTotal
    if (!this.isAnswerFinished) {
      this.showQuestion()
    } else {
      this.showFinish()
    }
  },
  showQuestion() {
    this.questionIndexLabel.string = 'Question ' + (this.questionIndex + 1) + ' / 5:'
    this.questionContentLabel.string = this.questions[this.questionIndex]

    this.answerPanel.active = true
    this.finishPanel.active = false
  },
  showFinish() {
    this.answerPanel.active = false
    this.finishPanel.active = true
  },
  formatDate() {
    return new Date().toISOString();
  },

  reportAnswer(answer) {
    let answerTime = this.formatDate();
    let reportMessage = {
      question: this.questions[this.questionIndex],
      answer: answer,
      answerTime: answerTime
    }
    window.analytics.onEvent("Answer", reportMessage)
  },

  postScore() {
    let scoreMessage = {}
    scoreMessage[agconnect.analytics.ParamName.SCORE] = this.score;
    window.analytics.onEvent(agconnect.analytics.EventName.SUBMITSCORE, scoreMessage);

    let scoreResult = {
      questionTotal: this.questionTotal,
      answers: this.answers,
      questions: this.questions,
      score: this.score,
      userAnswers: this.userAnswers
    }
    window.scoreResult = scoreResult
    this.clickBtnResult()
  }
});