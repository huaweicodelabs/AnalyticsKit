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
    scoreLabel: cc.Label,
    itemPanel: cc.Node,
    scrollContent: cc.Node
  },

  onLoad() {
    this.itemPanel.active = false
    this.showScore()
    this.showResult()
  },

  start() {},

  showScore() {
    this.scoreLabel.string = window.scoreResult.score
  },
  showResult() {
    for (let i = 0; i < window.scoreResult.questionTotal; i++) {
      let question = window.scoreResult.questions[i]
      let userAnswer = window.scoreResult.userAnswers[i]
      let answer = window.scoreResult.answers[i]

      let itemPanel = cc.instantiate(this.itemPanel)
      itemPanel.active = true
      itemPanel.getChildByName('QuestionContent').getComponent(cc.Label).string = question

      let toggle1 = itemPanel.getChildByName('QuestionChoose').getChildByName('toggle1').getComponent(cc.Toggle)
      let toggle2 = itemPanel.getChildByName('QuestionChoose').getChildByName('toggle2').getComponent(cc.Toggle)
      userAnswer ? toggle1.check() : toggle1.uncheck();
      !userAnswer ? toggle2.check() : toggle2.uncheck();
      itemPanel.getChildByName('QuestionAnswer').getChildByName('Answer').getComponent(cc.Label).string = answer.toString()
      itemPanel.getChildByName('QuestionAnswer').getChildByName('Answer').color = answer === userAnswer ? new cc.color(0, 255, 204, 255) : new cc.color(245, 82, 82, 255)
      this.scrollContent.addChild(itemPanel)
    }
  },

  clickBtnBack() {
    cc.director.loadScene("question")
  }
});